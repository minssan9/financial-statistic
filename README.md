#Financial Statistic 

### for launch
```groovy
gradlew build

gradlew :service build
```

### making Docker Image
```dockerfile
docker build -t fn-back .
```
will make docker image named 'fn-back'



docker login

docker push image fn-back .
