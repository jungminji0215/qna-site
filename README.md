# 목차
- [프로젝트 설명](#프로젝트-설명)
- [설계](#설계)
- [트러블 슈팅](#트러블슈팅)
- [브랜치 전략](#브랜치-전략)
- [관리](#관리)

<br>

## 프로젝트 설명
<p align="center">
<img src="https://user-images.githubusercontent.com/83000829/151507571-dd10b5e3-2153-471a-b6ca-97794e232686.gif" width = 700 />
</p>

- 간단한 질문 게시판 만들기 프로젝트입니다.

  
<br>

## 설계

<br>

## 트러블슈팅
다음은 프로젝트를 진행하면서 고민했던 부분입니다.
- 정리할 예정

<br>

## 브랜치 전략
<p align="center">
<img src = "https://user-images.githubusercontent.com/83000829/151507475-3021a291-6843-4ae9-b395-644a3c6c2ca6.png" width = 600 />
</p>

- gitlab 브랜치 전략을 사용하여 프로젝트를 진행하였습니다.
  - develop : 주요 개발 브랜치입니다. feature 브랜치에서 완료된 작업을 머지합니다.
  - feature : [주요 기능](https://github.com/jungminji0215/qna-site/issues)에 대한 작업을 하는 브랜치입니다.
    - 개발이 완료되면 PR을 올리고, 확인 후 develop에 머지하였습니다.
  - main : 개발이 완료되면 develop 내용을 반영하는 브랜치로, 버전을 관리하는 브랜치입니다.

<br>

## 관리
<p align="center">
<img src = "https://user-images.githubusercontent.com/83000829/151508334-a22fb0a1-e493-4593-a9d9-90a9436b748e.png" />
</p>

- 개발 feature는 [이슈](https://github.com/jungminji0215/qna-site/labels/%EA%B8%B0%EB%8A%A5%20%EA%B0%9C%EB%B0%9C)로 만들어서 관리하였습니다.
- 이슈는 feature 브랜치로 관리하였습니다.
  - feature 브랜치를 개발하면서 고민한 내용은 관련 이슈에 추가로 작성하였습니다.
- 프로젝트 진행 효율울 위해 프로젝트 [칸반보드](https://github.com/jungminji0215/qna-site/projects/1)를 활용하였습니다.
