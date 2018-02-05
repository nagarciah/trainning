docker run --rm -d -p 8080:8080 --name frontend -e "SPRING_PROFILES_ACTIVE=k8s" -e "GOALS_BACKEND_URL=http://192.168.0.7:8081/"  -v "/tmp:/tmp" goals-frontend

# O ver IP de contenedores con "docker network inspect bridge"
# docker run --rm -d -p 8080:8080 --name frontend -e "SPRING_PROFILES_ACTIVE=k8s" -e "GOALS_BACKEND_URL=http://172.17.0.3:8081/"  goals-frontend
