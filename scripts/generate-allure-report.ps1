$resultsPath = "target/allure-results"
$reportPath = "allure-report"

# 1. Run tests
mvn clean test

if ($LASTEXITCODE -ne 0) {
    Write-Warning "Tests failed. Allure report will still be generated."
}

# 2. Create Allure information
# 2.1 environment information
New-Item -ItemType Directory -Force -Path $resultsPath | Out-Null

$javaVersion = (java -version 2>&1 | Select-Object -First 1).ToString()
$osVersion = [System.Environment]::OSVersion.VersionString

@"
Execution=Local
OS=Windows
OS.Version=$osVersion
Java=$javaVersion
Browser=Chrome
"@ | Set-Content "$resultsPath/environment.properties"

# 2.2 executor information
@"
{
  "name": "Local Execution",
  "type": "local",
  "buildName": "Local Test Run",
  "buildUrl": "",
  "reportName": "Local Allure Report"
}
"@ | Set-Content "$resultsPath/executor.json" -Encoding UTF8

# 3. Restore history from the previous report
$previousHistory = "$reportPath/history"
$currentHistory = "$resultsPath/history"

if (Test-Path $previousHistory) {
    Copy-Item -Path $previousHistory `
              -Destination $currentHistory `
              -Recurse `
              -Force

    Write-Host "Allure history restored."
}
else {
    Write-Host "Previous Allure history not found. First run."
}

# 4. Generate Allure report
allure generate $resultsPath -o $reportPath --clean

if ($LASTEXITCODE -ne 0) {
    throw "Allure report generation failed."
}

# 5. Open report
allure open $reportPath