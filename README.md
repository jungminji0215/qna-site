# 목차
- [사용 기술](#사용-기술)
- [프로젝트 설명](#프로젝트-설명)
- [설계](#설계)
- [브랜치 전략](#브랜치-전략)
- [관리](#관리)
<!-- - [트러블 슈팅](#트러블슈팅) -->

<br>

## 사용 기술

<a><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=Hibernate&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>

<br>

## 프로젝트 설명
<p align="center">
<img src="https://user-images.githubusercontent.com/83000829/151507571-dd10b5e3-2153-471a-b6ca-97794e232686.gif" width = 700 />
</p>

- 간단한 질문 게시판 만들기 프로젝트
  - CRUD 개발
  - REST API 개발 

<br>

## 설계

<br>

<!--
## 트러블슈팅
다음은 프로젝트를 진행하면서 고민했던 부분
- 정리할 예정

<br>
-->

## 브랜치 전략
<p align="center">
<img src = "https://user-images.githubusercontent.com/83000829/152019170-7582ef08-fa7b-4e39-bc84-e623e31ab3bd.png" width = 700 />
</p>

- gitlab 브랜치 전략을 사용하여 프로젝트 진행
  - develop : 주요 개발 브랜치이며, feature 브랜치에서 완료된 작업을 머지
  - feature : [주요 기능](https://github.com/jungminji0215/qna-site/issues)에 대한 작업을 하는 브랜치
    - 개발이 완료되면 PR을 올리고, 확인 후 develop에 머지
  - main : 개발이 완료되면 develop 내용을 반영하는 브랜치로, 버전을 관리하는 브랜치

<br>

## 관리
<p align="center">
<img src = "https://user-images.githubusercontent.com/83000829/151508334-a22fb0a1-e493-4593-a9d9-90a9436b748e.png" />
</p>

- 개발 feature는 [이슈](https://github.com/jungminji0215/qna-site/labels/%EA%B8%B0%EB%8A%A5%20%EA%B0%9C%EB%B0%9C)로 만들어서 관리
- 이슈는 feature 브랜치로 관리
  - feature 브랜치를 개발하면서 고민한 내용은 관련 이슈에 추가로 작성
- 프로젝트 진행 효율울 위해 프로젝트 [칸반보드](https://github.com/jungminji0215/qna-site/projects/1)를 활용
