echo "Y llovio por 40 dias y 40 noches..."
kubectl delete all -l app=goals-frontend
kubectl delete all -l app=goals-backend
kubectl delete pvc -l app=goals-frontend
kubectl delete pv -l app=goals-frontend
kubectl delete endpoints -l app=goals-frontend
echo
echo "Finalizado. Ya pueden enviar la paloma..."
