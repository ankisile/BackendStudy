# IT 대기업 현업 개발자와 함께 하는 SW개발 실무(백엔드)

### 1주차
1. JDK 설치(11 version)
![image](https://user-images.githubusercontent.com/53250432/201106800-212ede25-5d82-4b56-97b3-ebb8828b16b2.png)

2. 이클립스, 스프링 설치
![image](https://user-images.githubusercontent.com/53250432/201106562-0e54af81-15ff-4960-8311-d2dd75dca9d6.png)

3. Hello World 출력
![image](https://user-images.githubusercontent.com/53250432/201106080-e7ef0ddb-3103-4173-a694-ac66a6742e1e.png)

4. db 설정
![Untitled](https://user-images.githubusercontent.com/53250432/201106960-c224eb89-37c8-407a-9148-8ebd72a22713.png)

5. 

######에러

설치 에러

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ceaada0f-f4f6-4181-bb8a-f2c7c7ef7dc8/Untitled.png)

찾아보니 다음과 같은 이유로 위와 같은 문제점이 발생했다.

<<**이 Spring Tools 3 Add-On for Spring Tools 4는 더 이상 유지 관리되거나 업데이트되지 않습니다. 최종 및 마지막 릴리스는 3.9.22이며, 이는 이클립스 2022-03용 스프링 툴 4.14.1 릴리스에 해당합니다. 더 이상 새 Spring Tools 4 또는 새 Eclipse 버전에 대한 업데이트는 없습니다. 대신 Spring Tools 4로 업그레이드하십시오.>>**

이클립스 2022-09 버전을 사용하고 있던것이 문제였던것으로 보인다.

>> 해결

****Eclipse 재설치****

에러 2

**The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application**



```
  <dependency>
    <groupId>jstl</groupId>

		<artifactId>jstl</artifactId>

		<version>1.2</version>

	</dependency>

```

추가 후 clean 해줌

