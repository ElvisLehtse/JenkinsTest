Remove existing container:
```
docker rm jenkins-test-container
```

Create new container using docker-compose.yml
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
