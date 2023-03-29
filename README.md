# conveniency

### Kotlin 편의성 라이브러리

---

* #### Features
    * for문 기반 반복문
    * Tread를 이용한 비동기 딜레이
    * Scheduler 기능 ~~-예정-~~
    * GitHub를 통한 업데이트

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

### EXAMPLE

* repeat
```kotlin
//it은 증가하는 값(for문의 변수(i) 역할), startVal의 기본 값 = 0, step의 기본 값 = 1
repeat({<action(it)>}, <times>, <startVal>, <step>)
```

* delay
```kotlin
delay(<time>, {<action>})
```

---

### Release \<Tag>

* com.github.cozy06:conveniency:1594953f16 <span style="color:green">23.3.38</span> **<span style="color:orange">[RECENT]</span>**

### NOTE

* 라이센스는 GPL-3.0이며 변경 혹은 삭제를 금합니다.

---

### Contributors


[![Jetbrains](https://i.ibb.co/fp0CyZ7/jetbrains.png)](https://jb.gg/OpenSource)
