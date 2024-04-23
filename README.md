# 😸🐶 반려동물 통합관리 시스템 및 제어 앱

<div align="right">
  마이크로프로세서및실험
  Date: 2022.04.23 - 2022.06.20
</div>
<br>

<!--표지 사진 추가-->

## 메인 아이디어
- 집에 혼자 있는 반려동물을 어떻게 관리할 수 있을까 ❓
- 사료 급여, 영상 시청, 온습도 확인, 녹음 기능을 통합하여 제어하자 💡
- 라즈베리파이와 여러 센서를 사용해 자동 급식기와 안드로이드 앱 제작 📲
<br>

## 사용자 인터페이스
<!--메인화면-->
<h3 align="center">
  여러 기능을 통합하여 간편하게 사용할 수 있어요! 👍 <br>
</h3>
<div align="center">
  <image src="https://brave-horse-48d.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fe71b3849-27b1-423d-b6f0-e80371d0f8e8%2Fimage11.png?table=block&id=ccc5b218-db74-4371-9e34-b93c0942b02f&spaceId=bbd4c5bb-0d54-4459-b0d9-4bdcefc6f6e3&width=380&userId=&cache=v2" width="249" height="443"/>
</div>
<hr>
    
<!--온습도-->
<h3 align="center">
  온습도를 실시간으로 확인해봐요! 🌡💧
</h3>
<!--사진첨부-->
<hr>

<!--사료급여-->
<h3 align="center">
  시간을 조절하여 사료를 급여해봐요! 🍴
</h3>
<div align="center">
  
   **원하는 양의 사료를 급여할 수 있어요 🤍** <br><br>
  <image src="https://github.com/irrso/Mobile_project/assets/105829324/24ecada9-7af6-4ed1-8287-3262d7db50d8" width="249" height="443"/>
  <br><br>
  바를 움직여서 원하는 사료 양을 조절해요.
</div>
<hr>

<!--영상시청-->
<h3 align="center">
  지금 당장 반려동물의 영상을 시청해봐요! 👀
</h3>
<div align="center">
  
  **지금 무엇을 하고있는지 확인할 수 있어요 🤍** <br><br>
  <image src="https://github.com/irrso/Mobile_project/assets/105829324/12cf01d6-878a-42c6-b38b-3c86b6df4822" width="249" height="443"/>
</div>
<hr>

<!--녹음기능-->
<h3 align="center">
  반려동물에게 여러분의 목소리를 들려주세요! 🔊
</h3>
<div align="center">
  
  **마이크를 눌러 녹음하고 내용을 확인 후 전송할 수 있어요 🤍** <br><br>
  <image src="https://github.com/irrso/Mobile_project/assets/105829324/3fca2055-9cb1-4abb-aea3-3e58a171ffbb" width="249" height="443"/>
  <br><br>
  마이크를 눌러 녹음을 시작하고 다시 눌러 녹음을 종료해요.<br><br>
  재생 및 정지 버튼을 통해 녹음 내용을 확인해요.<br><br>
  전송 버튼을 눌러 반려동물에게 목소리를 공유해봐요.
</div>
<br>

## 역할 분담
<!--표 추가-->
|팀장|팀원|팀원|
|:---:|:---:|:---:|
|[오소영](https://github.com/irrso)|***|***|
|앱 설계 및 제작 <br> 데이터베이스 연동 <br> 발표 자료 제작 및 제출 <br> 필요 물품 리스트업 및 수령 <br> 코드 형상관리|앱 제작 <br> firebase 데이터 전송 관리 및 구현 <br> 프로젝트 제안 및 최종 발표|자동 급식기 제작 및 센서 부착 <br> 라즈베리파이 센서 회로 설계 및 코드 구현|
<br>

## 기술 스택
|분류|기술 스택|
|---|---|
|S/W|<img src="https://img.shields.io/badge/Android-34A853.svg?style=flat-square&logo=android&logoColor=white"/> <img src="https://img.shields.io/badge/Android Studio-3DDC84.svg?style=flat-square&logo=androidstudio&logoColor=white"/> <img src="https://img.shields.io/badge/Java(JDK1.8)-007396.svg?style=flat-square&logo=java&logoColor=white"/>|
|H/W|<img src="https://img.shields.io/badge/Raspbian GNU/Linux 11-A22846.svg?style=flat-square&logo=raspberrypi&logoColor=white"/> <img src="https://img.shields.io/badge/Firebase-FFCA28.svg?style=flat-square&logo=firebase&logoColor=white"/> <img src="https://img.shields.io/badge/C-A8B9CC.svg?style=flat-square&logo=c&logoColor=black"/> <img src="https://img.shields.io/badge/Python-3776AB.svg?style=flat-square&logo=python&logoColor=white"/>|
|협업|<img src="https://img.shields.io/badge/KakaoTalk-FFCD00.svg?style=flat-square&logo=kakaotalk&logoColor=black"/> <img src="https://img.shields.io/badge/Google Docs-4285F4.svg?style=flat-square&logo=googledocs&logoColor=white"/> <img src="https://img.shields.io/badge/GitHub-181717.svg?style=flat-square&logo=github&logoColor=white"/>|

### 라즈베리파이
- `pi카메라`를 이용하여 영상 송출
- `서보모터`를 이용하여 사료 급여
- `스피커`를 이용하여 음성 재생
- `온습도센서`를 이용하여 온습도 표시

### firebase
- `feed`키를 통해 사료 관련 데이터 송수신
- `voice`키와 `recorded.wav`파일을 통해 음성 데이터 송수신
- `humidity`, `temperature`키를 통해 온습도 관련 데이터 송수신
<br>

## 시스템 개요
- 라즈베리파이: 자동 급식기에 부착된 센서 제어, pi카메라를 위한 웹 호스팅 역할
- 스마트폰: 앱을 통해 라즈베리파이에 데이터 전송 및 수신, 자동 급식기 논리적으로 제어하는 UI 역할
- firebase: 라즈베리파이와 스마트폰 앱 간의 전송 매개체 역할, 로컬에 국한되지 않은 제어 구현 [^id]
[^id]: 🚩 pi카메라를 통한 안심 카메라 기능은 도메인 설정 및 포워딩 등의 문제가 발생해 로컬로만 실행하도록 구상

|시스템 구상도|시스템 회로도|
|---|---|
|<img src="https://github.com/irrso/Mobile_project/assets/105829324/0198ef37-d9bd-457a-96d5-cbd92e2d47d5">|<img src="https://github.com/irrso/Mobile_project/assets/105829324/cac1aed3-de5f-4209-a72e-b3a6f99b7b2e">|
<br>

## 시스템 기능
### 자동 급식기
- 모터를 통해 자동으로 사료를 공급하는 하드웨어
<img src="https://github.com/irrso/MP_project_sy/assets/105829324/94c60ecd-5b54-47c2-a816-765e1017b092">

<details>
    <summary> 소스코드 </summary>

  ```Java
        //feed 초기값
        dbReference = FirebaseDatabase.getInstance().getReference();
        dbReference.child("feed").setValue(0);

        //사료주기
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i * 0.5;
                se.setText(progress + "초");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        feedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbReference = FirebaseDatabase.getInstance().getReference();

                //dbReference.child("feed").setValue(true);
                dbReference.child("feed").setValue(progress);
                Handler mHandler = new Handler();
                Toast.makeText(getApplicationContext(), "사료주기 완료", Toast.LENGTH_SHORT).show();

                /*mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dbReference.child("feed").setValue(false);
                        Toast t = Toast.makeText(getApplicationContext(), "사료주기 완료", Toast.LENGTH_SHORT);
                        t.show();
                    }
                },3000);*/
            }
        });
  ```
</details>

<details>
    <summary> 소스코드 </summary>

  ```Python


  ```
</details>

### 안심 카메라
- 혼자 있는 반려동물을 촬영하는 카메라
<img src="https://github.com/irrso/MP_project_sy/assets/105829324/55318799-9057-4cb4-aa7d-0526db9f2f9d">

<details>
    <summary> 소스코드 </summary>

  ```Java
         //영상보기
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });
  ```
</details>

<details>
    <summary> 소스코드 </summary>

  ```Python


  ```
</details>

### 안심 스피커
- 앱을 통해 전달된 음성 녹음을 반려동물에게 들려주는 스피커
<img src="https://github.com/irrso/MP_project_sy/assets/105829324/3201ea8a-a5ff-4ebf-9207-bcb3f5e703bd">

<details>
    <summary> 소스코드 </summary>

  ```Java
        //녹음하기
        voiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
                startActivity(intent);
            }
        });
  ```
</details>

<details>
    <summary> 소스코드 </summary>

  ```Python


  ```
</details>

### 온습도 측정
- 반려동물의 환경이 쾌적한 온습도인지 확인하는 시스템
<img src="https://github.com/irrso/MP_project_sy/assets/105829324/c79d1d29-6b12-4f73-8666-e91173a327c0">

<details>
    <summary> 소스코드 </summary>

  ```Java
        //온습도
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("temphumi");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Double value1 = snapshot.child("temperature").getValue(Double.class);
                Double value2 = snapshot.child("humidity").getValue(Double.class);
                te.setText(value1+"°C"); //"\'C"
                hu.setText(value2+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
  ```
</details>

<details>
    <summary> 소스코드 </summary>

  ```Python


  ```
</details>
