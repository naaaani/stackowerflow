<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
<h3 align="center">Stackoverflow</h3>
  <p align="center">
    Question sharing site built with Spring Boot.
    <br />
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

In this learning project we built an app similar to Stackoverflow. It's purpose was to get us acquainted with the Spring Boot framework.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![React][React.js]][React-url]
* [![Spring][Spring.js]][Spring-url]
* [![PostgreSQL][PostgreSQL.js]][PostgreSQL-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites
* npm
  ```sh
  npm install npm@latest -g
  ```

* JDK
    - <a href="https://www.oracle.com/java/technologies/downloads/">Download latest JDK version</a>
    - Install it
* maven
    - <a href="https://maven.apache.org/download.cgi">Download Maven</a>
    - Install it
* PSQL
    - <a href="https://www.postgresql.org/download/">Download PSQL</a>
    - Install it
### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/naaaani/stackowerflow.git
   ```
2. Install NPM packages in frontend directory
   ```sh
   npm install
   ```
3. Set your PSQL connection string in `application.properties`.
   ```
   connectionstring=yourstring;
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

You can add questions, answer them and vote on them. You can also delete questions.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

Project Link: [https://github.com/naaaani/stackowerflow](https://github.com/naaaani/stackowerflow)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/naaaani/stackowerflow.svg?style=for-the-badge
[contributors-url]: https://github.com/naaaani/stackowerflow/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/naaaani/stackowerflow.svg?style=for-the-badge
[forks-url]: https://github.com/naaaani/stackowerflow/network/members
[stars-shield]: https://img.shields.io/github/stars/naaaani/stackowerflow.svg?style=for-the-badge
[stars-url]: https://github.com/naaaani/stackowerflow/stargazers
[issues-shield]: https://img.shields.io/github/issues/naaaani/stackowerflow.svg?style=for-the-badge
[issues-url]: https://github.com/naaaani/stackowerflow/issues
[license-shield]: https://img.shields.io/github/license/naaaani/stackowerflow.svg?style=for-the-badge
[license-url]: https://github.com/naaaani/stackowerflow/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Spring.js]: https://img.shields.io/badge/Spring%20Boot-grey?style=for-the-badge&logo=Spring%20Boot&color=grey
[Spring-url]: https://spring.io/projects/spring-boot
[PostgreSQL.js]: https://img.shields.io/badge/PostgreSQL-grey?style=for-the-badge&logo=PostgreSQL&color=grey&logoColor=61DAFB
[PostgreSQL-url]: https://www.postgresql.org/docs/current/app-psql.html
