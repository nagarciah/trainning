export DOCKER_ID_USER="nagarciah"
docker login
docker tag goals-frontend $DOCKER_ID_USER/goals-frontend
docker push $DOCKER_ID_USER/goals-frontend
