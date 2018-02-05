# ver https://kubernetes.io/docs/concepts/workloads/controllers/deployment/
kubectl create -f <archivo.yml>
kubectl rollout status deployment/goals-backend-deployment
kubectl cluster-info
kubectl get nodes, pods, deployments --watch
kubectl get pods --show-labels
kubectl exec -it goals-backend-deployment-1913963472-9lqpb -- printenv
kubectl exec -it goals-frontend-deployment-3731469179-gtl17 -- telnet goals-backend-service 80

GET / HTTP/1.1
Host: localhost
Accept: application/json, image/gif, image/jpeg, */*
Accept-Language: en-us
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)
(blank line)

kubectl logs -f 

vars:
GOALS_BACKEND_SERVICE_SERVICE_HOST=10.11.240.7
GOALS_BACKEND_SERVICE_SERVICE_PORT=80
GOALS_FRONTEND_SERVICE_SERVICE_HOST=10.11.240.136
GOALS_FRONTEND_SERVICE_SERVICE_PORT=80

kubectl scale deployment goals-backend-deployment --replicas 1

kubectl set image deployment/goals-frontend-deployment <nombre del contenedor en tmp spec>=nagarciah/goals-frontend:latest
kubectl set image deployment/goals-frontend-deployment goals-frontend=nagarciah/goals-frontend:latest

kubectl rollout history deployment/goals-frontend-deployment
kubectl rollout undo deployment/goals-frontend-deployment [--to-revision=2]

# Si está detrás de un proxy:
NO_PROXY=kubemaster kubectl get nodes
# Y para docker detŕas de un proxy: # Proxy ver: https://docs.docker.com/engine/admin/systemd/#httphttps-proxy
