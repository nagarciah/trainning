# Proxy ver: https://docs.docker.com/engine/admin/systemd/#httphttps-proxy
docker run --rm -d -p 8081:8080 --name backend -e "SPRING_PROFILES_ACTIVE=perfil"  goals-backend
