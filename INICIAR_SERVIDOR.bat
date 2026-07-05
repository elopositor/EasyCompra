@echo off
title EasyCompra - Servidor Local
color 0A

echo ============================================
echo   EasyCompra - Servidor de datos
echo ============================================
echo.

:: Sincronizar Lidl (datos frescos)
echo [1/3] Sincronizando Lidl con Playwright...
cd /d "%~dp0backend"
python -m app.sync_lidl_only 2>&1 | find /V ""
echo.

:: Arrancar FastAPI
echo [2/3] Arrancando API en puerto 8123...
start "EasyCompra API" cmd /k "cd /d %~dp0backend && python -m uvicorn app.main:app --host 0.0.0.0 --port 8123"
timeout /t 3 /nobreak >nul

:: Arrancar ngrok
echo [3/3] Exponiendo al movil con ngrok...
echo    (La URL aparecera en la ventana de ngrok)
echo    (Copia esa URL y metela en la app Android)
echo.
start "ngrok Tunnel" "%~dp0ngrok.exe" http 8123

echo.
echo El servidor esta corriendo.
echo Busca la URL "https://xxxx.ngrok-free.app" en la ventana de ngrok.
echo.
pause
