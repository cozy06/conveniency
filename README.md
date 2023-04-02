# conveniency

### Kotlin 편의성 라이브러리

---

* #### Features
    * for문 기반 반복문
    * Tread를 이용한 비동기 딜레이
    * Scheduler 기능
    * GitHub를 통한 업데이트

* #### EXAMPLE
    * loop
   ```kotlin
   //it은 증가하는 값(for문의 변수(i) 역할), startVal의 기본 값 = 0, step의 기본 값 = 1
   loop({<action(it)>}, <times>, <startVal>, <step>)
   ```
    * delay
   ```kotlin
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
   //<Text>와 <Key>는 문자열
   val Key = <Text>.toJson().getString(<Key>)
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
* <4ea8ba0b64\> **_'23.3.30'_**
* <60e19a653b\> **_'23.3.30'_**
* <26a7bfedac\> **_'23.3.30'_**
* <078a194059\> **_'23.3.30'_**
* <2a101e62d2\> **_'23.3.30'_**
* <0c01bae0a6\> **_'23.4.2'_**
* <b1d6b88ea3\> **_'23.4.2'_**
* <1d0386992a\> **_'23.4.2'_** **[RECENT]**

### NOTE

* 라이센스는 GPL-3.0이며 변경 혹은 삭제를 금합니다.

---

### Contributors


[![Jetbrains](https://i.ibb.co/fp0CyZ7/jetbrains.png)](https://jb.gg/OpenSource)
