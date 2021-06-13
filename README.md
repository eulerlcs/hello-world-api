# hello-world-service
kp next architecture demo backend app

### architecture

- DDD
- OpenApi3 (springfox, swagger2)
- mybatis
- gib (docker image build)



### build

```bash
mvn clean install -Dmaven.test.skip=true
cd hello-world-api
mvn -Pdev jib:dockerBuild
```

### run

#### prepare mysql8

```
git clone hello-world-db
cd hello-world-db
cd mysql8
cd dev
docker-compose up -d
```

#### run by docker-compose

```
docker-compose -f docker\docker-compose-dev.yml up -d
```

