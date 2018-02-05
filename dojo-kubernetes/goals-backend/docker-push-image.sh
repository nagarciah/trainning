# Proxy ver: https://docs.docker.com/engine/admin/systemd/#httphttps-proxy
export DOCKER_ID_USER="nagarciah"
docker login
docker tag goals-backend $DOCKER_ID_USER/goals-backend
docker push $DOCKER_ID_USER/goals-backend
