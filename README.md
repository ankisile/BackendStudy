# IT 대기업 현업 개발자와 함께 하는 SW개발 실무(백엔드)
- [1주차](#1주차)
- [2주차](#2주차)
- [3주차](#3주차)
- [4주차](#4주차)
---
## 1주차
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

---
## 2주차
### ✔Rest API
* API(Application Programming Interface)란
	*  데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환가능 하도록 하는 것
* REST란
	* HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고,
	* HTTP Method(POST, GET, PUT, DELETE, PATCH 등)를 통해
	* 해당 자원(URI)에 대한 CRUD Operation을 적용하는 것
* REST API의 정의
	* REST 기반으로 서비스 API를 구현한 것
	* 최근 OpenAPI(누구나 사용할 수 있도록 공개된 API: 구글 맵, 공공 데이터 등), 마이크로 서비스(하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도록 만든 아키텍처) 등을 제공하는 업체 대부분은 REST API를 제공한다.

### ✔HTTP
* **Hypertext Transfer Protocol**
* HTTP는 서버와 클라이언트가 인터넷상에서 데이터를 주고 받기 위한 프로토콜(protocol)
* 클라이언트-서버 구조
* 무상태 프로토콜(Stateless)
	* 서버가 클라이언트 상태를 보존하지 않음
	* 장점 : 서버 확장성 높음 (스케일 아웃)
	* 단점 : 클라이언트가 추가 데이터 전송
* 비 연결성(Connectionless)
	* 비 연결성을 가지는 HTTP에서는 실제로 요청을 주고 받을 때만 연결을 유지하고 응답을 주고나면 TCP/IP 연결을 끊는다.
	* 이를 통해 최소한의 자원으로 서버 유지를 가능하게 한다.

### ✔브라우저에서 서버까지의 흐름
1. 사용자의 URL 요청
2. 브라우저의 URL 분석
> ##### URL
> * 인터넷에서의 자원의 위치  
> ![image](https://user-images.githubusercontent.com/53250432/202698836-70723ef9-461d-46d0-8eee-877fa52587d8.png)  
> **Protocol(프로토콜)** : 브라우저가 어떤 프로토콜을 사용해야 하는 지, 예를들어 http, https, ftp가 있다.   
> **Domain Name(도메인 이름)** : 어떤 웹 서버가 요구되는 지, 도메인 이름이 아닌 IP를 직접 입력해도 된다.   
> **Port(포트)** : 기술적으로 웹 서버에서 자원을 접근하기 위해 사용되는 gate   
> **Path to the file(경로)** : 자원에 대한 경로로, 초기 웹에서는 웹 서버 상에서의 물리적 파일 위치를 나타냈지만, 요즘에는 실제 물리적 경로를 나타내지 않고, 웹 서버에서 추상화하여 보여준다.   
> **parametas(파라미터)** : &기호 들로 구분된 key/value 짝을 이룬 리스트이다. 웹 서버는 자원을 반환하기 전에 추가적인 작업을 위해 파라미터를 사용할 수 있다.   
> **Anchor(닻)** : 일종의 자원의 북마크로, 웹에서 해당 북마크 지점을 보여주기 위해 브라우저에게 방향을 알려주는 역할을 한다. 또한, fragment identifier(부분 식별자)라고 알려져, 요청이 서버에 절대 보내지지 않는다.   
3. HSTS 목록 조회 
> **HTTP Strict Transport Security**   
>  HTTP 대신 HTTPS만을 사용하여 통신해야한다고 웹사이트가 브라우저에 알리는 보안 기능     
>  만약 HTTP로 요청이 왔다면 HTTP 응답 헤더에 "Strict Transport Security"라는 필드를 포함하여 응답하고 이를 확인한 브라우저는 해당 서버에 요청할 때 HTTPS만을 통해 통신하게 된다. 그리고 자신의 HSTS캐시에 해당 URL을 저장하는데 이를 HSTS 목록이라고 부른다.
4. URL을 IP주소로 변환
	* 브라우저에서는 자신의 로컬 hosts 파일과 브라우저 캐시에 해당 URL이 존재하는지 확인한다. 
	* 존재하지 않는다면 도메인 주소를 IP주소로 변환해주는 DNS(Domain Name System) 서버에 요청하여 해당 URL을 IP주소로 변환
> **DNS 서버로 요청하는 과정**   
> 1. 도메인 주소를 Local DNS에 전달한다.
> 2. Local DNS는 Root DNS에 도메인 주소를 보내고 이에 맞는 IP 주소를 요청하게 된다.
> 3.  Root DNS에서 도메인을 관리하는 서버에 대한 정보를 받는다. Root DNS는 IP 주소를 저장하는 것이 아니라, ".com"의 서버에 대한 정보만 가지고 있다. 고로 해당 ".com" 서버에 대한 정보를 Local DNS에 보낸다.
> 4. ".com" 서버로 접근해 다시 도메인 주소를 보낸다. 3에서 얻은 ".com" 서버에 도메인 주소를 보내 IP 주소를 요청한다.
> 5. ".com" 서버는 진짜 IP 주소를 가진 네임 서버의 정보를 반환한다.
> 6. 네임 서버에 도메인 주소를 보낸다.
> 7. 네임 서버로부터 IP 주소를 받는다.
> 8. IP 주소 정보가 실제 컴퓨터에 응답된다.
5. 라우터를 통해 해당 서버의 게이트웨이까지 이동
6. ARP를 통해 IP주소를 MAC주소로 변환
7. 대상 서버와 TCP 소켓 연결
> **3 way HandShaking**
> * 1단계(SYN) : 첫 번째 단계에서 클라이언트는 서버와 연결을 설정하기 원하므로 SYN(동기화 시퀀스 번호)이 포함된 세그먼트를 서버에 전송하여 클라이언트가 통신을 시작할 가능성이 있고 어떤 시퀀스로 통신을 시작할 것인지 서버에 알린다. (세그먼트를 시작하는 번호)
> * 2단계(SYN+ACK) : 서버는 SYN-ACK 신호 비트가 설정된 클라이언트 요청에 응답한다. Acknowledgement(ACK)는 수신한 세그먼트의 응답을 나타내고 SYN은 세그먼트를 시작할 가능성이 있는 시퀀스 번호를 나타낸다.
> * 3단계(ACK) : 마지막 부분에서 클라이언트는 서버의 응답을 확인하고 둘 다 실제 데이터 전송을 시작할 안정적인 연결을 설정한다.
8. HTTP(HTTPS) 프로토콜로 요청, 응답
9. 브라우저에서 응답을 해석 및 출력

---
## 3주차
##### ✔ SpringBoot 개발환경 세팅
![image](https://user-images.githubusercontent.com/53250432/203898090-68353c8a-1a99-4c5e-b9dd-916e679bddb8.png)
##### ✔ DB 테이블 생성
###### request Code 테이블
![image](https://user-images.githubusercontent.com/53250432/203905504-0cc95f1a-5ef2-42f9-9b22-29259541facc.png)
###### request Info 테이블
![image](https://user-images.githubusercontent.com/53250432/203905582-4caf8b05-0e76-41ab-8cf7-a9c22ea5f506.png)
###### user 테이블
![image](https://user-images.githubusercontent.com/53250432/203909723-67aa4397-c90c-41e8-9925-1e43c460a570.png)
##### ‼ [20년도 로그인수 API ]스프링부트, Mybatis, mariadb 연동 -> eclipse 상에서 다시 시도하니 해결
![image](https://user-images.githubusercontent.com/53250432/204781792-b653af24-2d9d-47f4-8983-4acb91e267f2.png)     
      
IntelliJ에서 계속 시도하였으나 계속 Invalid bound statement (not found) exception이 전달되고 해결되지 않음.   
이부분은 추후에 다시 찾아봐야 된다. 

##### ✔ SW활용 현황 통계 API 구축을 위한 SQL(수정 완료)
```	
# 월별 접속자수
select count(distinct userID) from statistic.requestInfo where LEFT(createDate, 4) = #{yearMonth};
# 일자별 접속자 수 
select count(distinct userID) from statistic.requestInfo where LEFT(createDate, 6) = #{yearMonthDate};
# 평균 하루 로그인 수
select count(*) as loginNum from statistic.requestInfo ri where ri.requestCode = 'L' and LEFT(createDate, 4) = #{yearMonth};
# 주말 제외한 로그인 수
select ri.createDate as createDate from statistic.requestInfo ri where ri.requestCode = 'L' and  left(ri.createDate, 4) = #{yearMonth} and dayofweek(ri.createDate)!= 1 and dayofweek(ri.createDate)!= 7;
# 부서별 월별 로그인 수
select count(*) from statistic.requestInfo r join statistic.user u on r.userID = u.USERNAME where LEFT(r.createDate, 4) =  #{yearMonth}  and  u.HR_ORGAN = #{organization} and r.requestCode = 'L';
```

---
## 4주차
##### ✔ 월별 접속자수
![image](https://user-images.githubusercontent.com/53250432/204834870-d8e7bc69-ecf5-49c6-8965-112dd189cff8.png)

##### ✔ 일자별 접속자 수
![image](https://user-images.githubusercontent.com/53250432/204835428-e9286728-0c1d-4a76-97d9-cc3fae4bf29e.png)

##### ✔ 평균 하루 로그인 수
![image](https://user-images.githubusercontent.com/53250432/204845437-7b91bc1b-777e-4443-8492-d54f12a6036d.png)
   
Calendar 클래스를 이용하여 마지막 날짜를 구하고 이 날짜로 로그인수를 나눠주었다.
##### ✔ 부서별 월별 로그인 수
![image](https://user-images.githubusercontent.com/53250432/204852249-3b50f1ab-7521-4df1-8196-d10350d1f1fc.png)

##### ✔ 휴일을 제외한 로그인 수
2022년 8월의 휴일을 제외한 로그인수를 가져오고자 하였고 데이터는 다음과 같다.     
![image](https://user-images.githubusercontent.com/53250432/205070728-bfe17109-9353-434c-a25d-71e5d2bc2d4a.png)       
2020년 8월의 로그인은 데이터는 5개임을 확인할 수 있고 휴일을 제거하면 4개이다.      
![image](https://user-images.githubusercontent.com/53250432/205095467-c6c7b3b1-46b1-4c47-ab7d-307830796391.png)
     
      
##### ✔ 휴일 구할때 공공 api 이용!     
https://www.data.go.kr/data/15012690/openapi.do

제공하고 있는 sample code를 이용하여 데이터를 xml 형태로 가져왔고 xml을 json으로 바꿔서 locdate(날짜)를 얻어오고자 했다.
[참고자료]    
https://bohemihan.tistory.com/entry/Open-API-%EA%B5%AD%EA%B2%BD%EC%9D%BC-%EA%B3%B5%ED%9C%B4%EC%9D%BC-%EA%B5%AC%ED%95%98%EA%B8%B0
     
❓ **궁금한 점**    
현재 db에 저장되어 있는 데이터 양이 작아서 for문을 이용하여 공휴일이 아니면 데이터를 가져오는 식으로 했는데 데이터 양이 많아질 경우 어떻게 처리해야 될지 궁금하다.    
예를 들어, 공공 api의 데이터를 db에 저장해서 sql 쿼리문을 짤때 처리하는지, 혹은 다른 방법으로 처리하는지에 대해 궁금하다.
