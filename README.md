# spring-mybatis-combine

a picture similarity demo with perceptual hash algorithm.

## Usage

1\. clone the source code:

```shell
git clone https://github.com/xitongjiagoushi/picture-similarity.git
$ cd picture-similarity
```

2\. import the source code to your IDE as a maven project, or just use maven to pack:

```shell
mvn package
```

3\. deploy the .war package in your web container, here we use [Tomcat](http://tomcat.apache.org/) and default configuration.

4\. view the the URL in your web browser:

```shell
http://localhost:8080/picture-similarity/static/index.html
```

5\. try to upload a picture and see the change.


## TODO List
- [ ] upload origin pictures to teach the program what picture you want to use as the base.
- [ ] use database to store the base perceptual hash.

## Any Problems
[mail to me](mailto:root@brctl.com)
