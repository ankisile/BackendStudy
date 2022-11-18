# IT 대기업 현업 개발자와 함께 하는 SW개발 실무(백엔드)
[1주차](### 1주차)
[2주차](### 2주차)
---
### 1주차
##### ✔ JDK 설치(11 version)
![image](https://user-images.githubusercontent.com/53250432/201106800-212ede25-5d82-4b56-97b3-ebb8828b16b2.png)

##### ✔ 이클립스, 스프링 설치
![image](https://user-images.githubusercontent.com/53250432/201106562-0e54af81-15ff-4960-8311-d2dd75dca9d6.png)

##### ✔ Hello World 출력
![image](https://user-images.githubusercontent.com/53250432/201106080-e7ef0ddb-3103-4173-a694-ac66a6742e1e.png)

##### ✔ db 설정(DataGrip 이용)
![Untitled](https://user-images.githubusercontent.com/53250432/201106960-c224eb89-37c8-407a-9148-8ebd72a22713.png)

##### ✔ 스프링, myBatis, mariaDB 연동
![image](https://user-images.githubusercontent.com/53250432/201114843-2ab115f6-6769-4eb5-b021-9362108fd411.png)

###### ✔ 중간퀴즈 : MovieVO.java 작성해보기
```
package com.devfun.vo;

public class MovieVO {
	private String movie_name;
	private String director;
	private String types;
	
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}	
}
```

### 에러
#### ‼ 에러 1

![image](https://user-images.githubusercontent.com/53250432/201116935-0ad6c692-3cfd-478e-b659-6bf66a38b861.png)

찾아보니 다음과 같은 이유로 위와 같은 문제점이 발생했다.

<<**이 Spring Tools 3 Add-On for Spring Tools 4는 더 이상 유지 관리되거나 업데이트되지 않습니다. 최종 및 마지막 릴리스는 3.9.22이며, 이는 이클립스 2022-03용 스프링 툴 4.14.1 릴리스에 해당합니다. 더 이상 새 Spring Tools 4 또는 새 Eclipse 버전에 대한 업데이트는 없습니다. 대신 Spring Tools 4로 업그레이드하십시오.>>**

이클립스 2022-09 버전을 사용하고 있던것이 문제였던것으로 보인다.

>> 해결

****Eclipse 재설치. 2021-12 version으로 재설치 했다.****

#### ‼ 에러 2

**The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application**
>> 해결
```
  <dependency>
    <groupId>jstl</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
   </dependency>

```
위의 코드를 pom.xml에 추가한 후 clean 해주었다.

#### ‼ 에러 3
**context:component-scan" is not bound**

context:component-scan 을 인식하지 못하는 에러. 
>> 해결
root-context.xml 파일에서 다음과 같이 수정
```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	https://www.springframework.org/schema/beans/spring-beans.xsd 
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-3.0.xsd">
```
### Question
#### ❓ mapper vs repository
---
### 2주차
#### Rest API
##### HTTP란?
