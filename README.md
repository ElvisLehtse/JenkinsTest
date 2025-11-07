## Docker

Remove existing container:
```
docker rm jenkins-test-container
```

Create new container using docker-compose.yml:
```
docker compose up --build
```

Create and start a new container image manually (w/o yml config):
```
docker run --name jenkins-test-container -p 8080:8080 jenkinstest:latest
```

Start existing container:
```
docker start -a jenkins-test-container
```

## Jenkins
Run in Powershell to
1. create and run Jenkins in local Docker container:
2. create (or reuse, if it already exists) a volume to store Jenkins’ configuration, plugins and user accounts
```
docker run -d `
  --name jenkins-local `
  -p 8081:8080 -p 50000:50000 `
  -v jenkins_home:/var/jenkins_home `
  -v /var/run/docker.sock:/var/run/docker.sock `
  jenkins/jenkins:lts
```

Open Docker in browser:   
http://localhost:8081

Require password (first time, if volume is removed):
```
docker exec -it jenkins-local cat /var/jenkins_home/secrets/initialAdminPassword
```

Remove container:
```
docker rm jenkins-local
```

Remove volume (DO NOT REMOVE):
```
docker volume rm jenkins_home
```

Run container:
```
docker start -a jenkins-local
```

If the volume is removed, then run these in Powershell to install the Docker CLI for Jenkins docker container:
```
docker exec -it --user root jenkins-local bash
apt-get update
apt-get install -y docker.io
```
