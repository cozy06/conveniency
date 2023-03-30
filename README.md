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
   delay(<time>, {<action>})
   ```
    * Scheduler
   ```kotlin
   //schedule 생성
   val shd: Scheduler = newScheduler({<action>})
   
   //schedule 추가
   shd.addSchedule(Schedule(<time>, <action>))
   
   //schedule 제거
   shd.removeSchedule(<index>)
   
   //schedule 실행
   runScheduler(shd)
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
* <1594953f16\> -**_'23.3.28'_**
* <4ea8ba0b64\> -**_'23.3.30'_**
* <52031edea6\> -**_'23.3.30'_**
* <60e19a653b\> -**_'23.3.30'_** **[RECENT]**

### NOTE

* 라이센스는 GPL-3.0이며 변경 혹은 삭제를 금합니다.

---

### Contributors


[![Jetbrains](https://i.ibb.co/fp0CyZ7/jetbrains.png)](https://jb.gg/OpenSource)
