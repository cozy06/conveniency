# conveniency

### Kotlin 편의성 라이브러리

---

* #### Features
    * for문 기반 반복문
    * Tread를 이용한 비동기 딜레이 및 작업
    * Scheduler 기능
    * 파일 읽기와 쓰기
    * json으로 변환
    * Http 통신 보내기 (POST / GET)
    * hash 암호화
    * Email 송신
    * GitHub를 통한 업데이트

* #### EXAMPLE
    * Logic
   ```kotlin
   //it은 List의 인덱스 별 값, range함수 이용
   loop(<List<Any>>) {<action(it)>}
  
   //step의 기본값은 1, List 리턴
   range(<startValue: Int>, <endValue: Int>, <step: Int>)
   정
   //input의 매개변수는 입력 전 출력할 문자, 기본값은 없음 
   val input = input()
   
   //inputPW의 매개변수는 입력 전 출력할 문자, 기본값은 없음 
   val pw = inputPW()
   ```
    * Async
   ```kotlin
   //비동기 <action>
   async { <action> }
   
   //비동기 딜레이 <action>
   delay(<time>) { <action> }
   ```
    * Scheduler
   ```kotlin
   //schedule 생성
   val shd: Scheduler = newScheduler { <action> }
   
   //schedule 추가
   shd.addSchedule(Schedule(<time>, { <action> }))
   
   //schedule 제거
   shd.removeSchedule(<index>)
   
   //schedule 삽입
   shd.removeSchedule(<index>, <Schedule>)
   
   //schedule 수정
   shd.removeSchedule(<index>, <Schedule>)
   
   //schedule 실행
   runScheduler(shd)
   
   //schedule 중단
   stopScheduler(shd)
   ```
    * File
   ```kotlin
   //파일 읽기
   val text = <File>.readFile()
   
   //파일 작성
   <File>.writeAll(<Text>)
   
   //파일 내용 추가
   <File>.addLine(<Text>)
   
   //파일 내용 삽입
   <File>.insertLine(<index>, <Text>)
   ```

  * Json
  ```kotlin
  //<Text>는 문자열
  val Key = <Text>.toJson()
  ```
  
  * HTTPRequest
  ```kotlin
  //<URL>, <KEY>, <VALUE>들은 모두 문자열이고 <PrintResponseCode>의 기본 값 = false
  URL(<URL>).httpPOST(params(<KEY1> to <VALUE1>, <KEY2> to <VALUE2>, ...), <PrintResponseCode>)
  
  //<URL>, <KEY>, <VALUE>들은 모두 문자열이고 <header>의 기본 값 = header("Content-Type" to "application/json") 그리고 <PrintResponseCode>의 기본 값 = false
  URL(<URL>).httpGET(params(<KEY1> to <VALUE1>, <KEY2> to <VALUE2>, ...), <header>, <PrintResponseCode>)
  ```
  * Email
  ```kotlin
  sendEmail(<receiver>, <subject>, <body>, <sender>, <appPassword>)
  ```

  * Encryption
  ```kotlin
  // <type>의 기본값: SHA-256
  hashEncryption(<Text>, <type>)
  ```

---

### Gradle `conveniency`

```kotlin
repositories {
    ...
    maven { url = uri("https://jitpack.io") }
}
```

```kotlin
dependencies {
    implementation("com.github.cozy06:conveniency:<Tag>")
}
```

---

### Release \<Tag>

* "com.github.cozy06:conveniency:\<Tag>"
* <1594953f16\> **_'23.3.28'_**
* <2a101e62d2\> **_'23.3.30'_**
* <1d0386992a\> **_'23.4.2'_**
* <b2f8b9f1f4\> **_'23.4.4'_**
* <a9bbb5bbae\> **_'23.4.6'_**
* <b80d835185\> **_'23.4.8'_**
* <25f71ecf55\> **_'23.4.9'_**
* <34e2ea4118\> **_'23.5.27'_**
* <2081a20771\> **_'24.1.20'_** **[RECENT]**

### NOTE

* 라이센스는 GPL-3.0이며 변경 혹은 삭제를 금합니다.

---

### Contributors


[![Jetbrains](https://i.ibb.co/fp0CyZ7/jetbrains.png)](https://jb.gg/OpenSource)
