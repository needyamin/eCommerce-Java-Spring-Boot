# Script to run Flyway migrations
# This script starts the Spring Boot application which automatically runs Flyway migrations

Write-Host "Starting Spring Boot application..." -ForegroundColor Green
Write-Host "Flyway will automatically run migrations on startup" -ForegroundColor Yellow
Write-Host ""

# Stop any existing Java processes
Get-Process | Where-Object {$_.ProcessName -eq 'java'} | Stop-Process -Force -ErrorAction SilentlyContinue

# Build the project
Write-Host "Building project..." -ForegroundColor Cyan
.\gradlew.bat clean build -x test

if ($LASTEXITCODE -eq 0) {
    Write-Host "Build successful! Starting application..." -ForegroundColor Green
    Write-Host ""
    Write-Host "Migrations will run automatically. Look for messages like:" -ForegroundColor Yellow
    Write-Host "  - 'Flyway migration successful'" -ForegroundColor Yellow
    Write-Host "  - 'Migrating schema to version X'" -ForegroundColor Yellow
    Write-Host ""
    
    # Start the application
    .\gradlew.bat bootRun
} else {
    Write-Host "Build failed! Please check errors above." -ForegroundColor Red
}

