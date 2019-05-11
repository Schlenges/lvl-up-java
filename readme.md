# LVL UP Spring App

## About

A trimmed down version of the original [Lvl Up application](https://github.com/Schlenges/lvl-up) using Java, SpringBoot and Thymeleaf.

## Installation

This project uses a maven wrapper, so all you need to do is clone the repo, open your folder in a terminal and run

for Unix (Linux, OSX, ...)
```
./mvnw clean install
```
for Batch (Windows)
```
./mvnw.cmd clean install
```
<br>
To start the application, run:

```
./mvnw spring-boot:run
```

## Usage

The application starts with some sample data, but uses [H2](https://www.h2database.com/html/main.html) as an in-memory database and won't store anything to disk.

To try the application, open **localhost:8080/skills** to see an overview and to add new skills. Klick on the name of a skill to add battles to it or to update your XP.