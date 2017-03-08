# ZenContact in ActFramework

This application port [PlayFramework v1.x](https://github.com/playframework/play1)'s [zencontact](https://github.com/playframework/play1/tree/master/samples-and-tests/zencontact) sample to [ActFramework](http://actframework.org)

## Start the application

Start the application in dev mode

```
mvn clean compile exec:exec
```

Start the application in prod mode

```
mvn clean package
cd target/dist
unzip *
./start
```

Once application has been started, you can open browser and locate to `http://localhost:5460` get the home page.

