# Ver: https://help.ubuntu.com/community/NFSv4Howto
#docker run -d --name nfs4-server --privileged -p 2049:2049 -v /directorio-exportar:/nfsshare -e SHARED_DIRECTORY=/nfsshare itsthenetwork/nfs-server-alpine:latest

#sudo apt-get install nfs-common 
#sudo mount -t nfs4 -o proto=tcp,port=2049 localhost:/directorio-importar
# Para NFSv4 Ver: https://kubernetes.io/docs/concepts/storage/persistent-volumes/


# Otra opción: https://github.com/tangjiujun/docker-nfs-server
#sudo apt-get install nfs-common 
#sudo mount -t nfs3 -o proto=tcp,port=2049 localhost:/directorio-importar
# TODO Cambiar a pod o instalar en docker (sudo yum -y install docker)
docker run -d --privileged --restart=unless-stopped \
    -v /home/nadia_olivia_petra/directorio-exportar:/nfsshare \
    -p 111:111 -p 111:111/udp \
    -p 2049:2049 -p 2049:2049/udp \
    -p 32765-32768:32765-32768 -p 32765-32768:32765-32768/udp \
    --name nfs3-server tangjiujun/nfs-server:v1.0

# Instalar NFS Server en CentOS7: https://www.howtoforge.com/nfs-server-and-client-on-centos-7
yum -y install nfs-utils
sudo mkdir /var/nfsshare
sudo chmod -R 755 /var/nfsshare
sudo chown nfsnobody:nfsnobody /var/nfsshare

sudo systemctl enable rpcbind
sudo systemctl enable nfs-server
sudo systemctl enable nfs-lock
sudo systemctl enable nfs-idmap
sudo systemctl start rpcbind
sudo systemctl start nfs-server
sudo systemctl start nfs-lock
sudo systemctl start nfs-idmap

#sudo yum -y install nano
#sudo nano /etc/exports
sudo echo "/var/nfsshare    *(rw,sync,no_root_squash,no_all_squash)" >> /etc/exports
sudo echo "/home            *(rw,sync,no_root_squash,no_all_squash)" >> /etc/exports

sudo systemctl restart nfs-server

sudo firewall-cmd --permanent --zone=public --add-service=nfs
sudo firewall-cmd --permanent --zone=public --add-service=mountd
sudo firewall-cmd --permanent --zone=public --add-service=rpc-bind
sudo firewall-cmd --reload
# Queda en el puerto 2049

# Montar el cliente: https://www.digitalocean.com/community/tutorials/how-to-set-up-an-nfs-mount-on-ubuntu-16-04
sudo mount 35.184.31.239:/var/nfsshare ./nfs-server-mount/
