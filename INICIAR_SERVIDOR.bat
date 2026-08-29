@echo off
title EasyCompra - Servidor Local
color 0A

echo ============================================
echo   EasyCompra - Servidor de datos (opcional)
echo ============================================
echo.
echo La app ya no necesita este servidor: descarga los datos
echo publicados en GitHub y se actualizan solos cada dia.
echo.
echo Esto solo hace falta para probar cambios del backend.
echo.

:: Sincronizar Lidl (datos frescos)
echo [1/2] Sincronizando Lidl con Playwright...
cd /d "%~dp0backend"
python -m app.sync_lidl_only 2>&1 | find /V ""
echo.

:: Arrancar FastAPI
echo [2/2] Arrancando API en puerto 8123...
start "EasyCompra API" cmd /k "cd /d %~dp0backend && python -m uvicorn app.main:app --host 0.0.0.0 --port 8123"
timeout /t 3 /nobreak >nul

echo.
echo El servidor esta corriendo en http://localhost:8123
echo Desde el movil, en la misma WiFi: http://TU-IP-LOCAL:8123
echo.
echo NOTA DE SEGURIDAD: la API no lleva contrasena. Escucha en toda
echo la red local, asi que cualquiera conectado a tu WiFi podria
echo llamarla. No la expongas a internet (ngrok, redireccion de
echo puertos en el router) sin ponerle antes autenticacion: el
echo endpoint /sync/all lanza navegadores en este PC.
echo.
pause
