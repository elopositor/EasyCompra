#!/bin/bash
# ============================================================
# EasyCompra - Setup en Oracle Cloud Free Tier (Ubuntu 22.04 ARM)
# Ejecutar con: bash setup.sh
# ============================================================
set -e

echo "=== 1/5 Actualizando sistema ==="
sudo apt-get update -y && sudo apt-get upgrade -y

echo "=== 2/5 Instalando Docker ==="
curl -fsSL https://get.docker.com | sudo sh
sudo usermod -aG docker $USER

echo "=== 3/5 Instalando Docker Compose ==="
sudo apt-get install -y docker-compose-plugin

echo "=== 4/5 Abriendo puertos en el firewall local ==="
sudo iptables -I INPUT -p tcp --dport 8123 -j ACCEPT
sudo iptables -I INPUT -p tcp --dport 80 -j ACCEPT
# Persistir iptables
sudo apt-get install -y iptables-persistent -y
sudo netfilter-persistent save

echo "=== 5/5 Levantando EasyCompra ==="
mkdir -p data
sudo docker compose up -d --build

echo ""
echo "✅ EasyCompra instalado y corriendo."
echo "   API disponible en: http://$(curl -s ifconfig.me):8123"
echo "   Prueba: curl http://$(curl -s ifconfig.me):8123/health"
echo ""
echo "⚠️  IMPORTANTE: En Oracle Cloud también debes abrir el puerto 8123"
echo "   en la Security List de tu VCN (Virtual Cloud Network)."
echo "   Ve a: Networking → Virtual Cloud Networks → tu-VCN → Security Lists → Ingress Rules"
echo "   Añade: Protocol TCP, Source 0.0.0.0/0, Destination Port 8123"
