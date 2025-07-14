param(
    [string]$nacosHost = "localhost",
    [string]$nacosPort = "8848",
    [string]$group = "SEATA_GROUP",
    [string]$tenant = "",
    [string]$username = "",
    [string]$password = ""
)

$nacosAddr = "$nacosHost`:$nacosPort"
$contentType = "content-type:application/json;charset=UTF-8"

Write-Host "set nacosAddr=$nacosAddr"
Write-Host "set group=$group"

function Add-UrlEncode {
    param([string]$text)
    return [uri]::EscapeDataString($text)
}

function Add-Config {
    param([string]$dataId, [string]$content)
    
    $encodedDataId = Add-UrlEncode $dataId
    $encodedContent = Add-UrlEncode $content
    
    $url = "http://$nacosAddr/nacos/v1/cs/configs?dataId=$encodedDataId&group=$group&content=$encodedContent&tenant=$tenant&username=$username&password=$password"
    
    try {
        $response = Invoke-RestMethod -Uri $url -Method POST -ErrorAction Stop
        if ($response -eq "true") {
            Write-Host "Set $dataId=$content successfully"
            return $true
        } else {
            Write-Host "Set $dataId=$content failure"
            return $false
        }
    }
    catch {
        Write-Host "Error setting $dataId`: $_"
        return $false
    }
}

# Read config.txt and process each line
$configPath = Join-Path $PSScriptRoot "..\config.txt"
$lines = Get-Content $configPath

$count = 0
$failCount = 0

foreach ($line in $lines) {
    $line = $line.Trim()
    if ($line -and -not $line.StartsWith("#")) {
        $count++
        $parts = $line.Split("=", 2)
        if ($parts.Length -eq 2) {
            $key = $parts[0].Trim()
            $value = $parts[1].Trim()
            $success = Add-Config $key $value
            if (-not $success) {
                $failCount++
            }
        }
    }
}

Write-Host "========================================================================="
Write-Host " Complete initialization parameters,  total-count:$count ,  failure-count:$failCount "
Write-Host "========================================================================="

if ($failCount -eq 0) {
    Write-Host " Init nacos config finished, please start seata-server. "
} else {
    Write-Host " init nacos config fail. "
} 