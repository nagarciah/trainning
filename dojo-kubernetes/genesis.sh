echo "Hagase la luz! (Creando backend...)"
kubectl create -f goals-backend
echo
echo "Haganse los cielos! (Creando almacenamiento del frontend...)"
kubectl create -f goals-frontend/1-nfs-server/nfs-server-external/
echo
echo "Hagase la tierra! (Creando frontend...)"
kubectl create -f goals-frontend/2-frontend/in-gke-with-nfs-pv/
echo
echo "...y todo lo demas! (Creando load balancer del frontend...)"
kubectl create -f goals-frontend/2-frontend/frontend-gce-service.yml
echo
echo "Y como vio que todo habia sido creado, al septimo dia descanso... (Creacion completa)"
