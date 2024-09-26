<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/csv-worker/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/csv-worker/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/csv-worker/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/csv-worker)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/csv-worker.svg?style=flat)](https://github.com/astrapi69/csv-worker/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/csv-worker/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/csv-worker)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/csv-worker.svg)](http://www.javadoc.io/doc/io.github.astrapi69/csv-worker)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/csv-worker?branch=develop)](https://hitsofcode.com/github/astrapi69/csv-worker/view?branch=develop)

</div>

# Overview

A collection of utility classes for handling CSV files in Java. This library provides various functionalities, including reading, writing, sorting, and converting CSV data to SQL scripts.
Features

* CsvBean: Represents a structured data model for CSV files with support for headers, column types, and lines of data.
* CsvExtensions: Utility methods for reading CSV data and mapping it to objects.
* CsvFileExtensions: File-based operations for reading, writing, and processing CSV files.
* CsvToSqlExtensions: Methods to generate SQL insert scripts from CSV data.

# Usage

Reading a CSV File

```java

File csvFile = new File("path/to/csv-file.csv");
List<String[]> data = CsvFileExtensions.readFileToList(csvFile, ",", "UTF-8");
```

Sorting CSV Data

```java
Path csvFilePath = Paths.get("path/to/csv-file.csv");
CsvExtensions.sortCsvByAlgorithmAndKeysize(csvFilePath);
```

Converting CSV to SQL

```java

CsvBean csvBean = new CsvBean(headers, columnTypes, lines);
String sqlScript = CsvToSqlExtensions.getCsvFileAsSqlInsertScript("my_table", csvBean);
```

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/csv-worker" data-icon="octicon-star" aria-label="Star astrapi69/csv-worker on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making csv-worker great for all types of applications.

## Import dependencies to your project

<details>
  <summary>gradle (click to expand)</summary>

## gradle dependency

Replace the variable ${latestVersion} with the current latest
version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/csv-worker/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/csv-worker)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of csv-worker:

define version in file gradle.properties

```
csvWorkerVersion=${latestVersion}
```

or in build.gradle ext area

```
    csvWorkerVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:csv-worker:$csvWorkerVersion")
```

# with new libs.versions.toml file

If you use the new libs.versions.toml file for new automatic catalog versions update

```
[versions]
```
```
csv-worker-version= "${latestVersion}"
```
```
[libraries]
```
```
csv-worker = { module = "io.github.astrapi69:csv-worker", version.ref = "csv-worker-version" }
```

then add the dependency to the dependencies area

```
    implementation libs.csv.worker
```

</details>

<details>
  <summary>Maven (click to expand)</summary>

## Maven dependency

Maven dependency is now on sonatype.
Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~csv-worker~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of csv-worker:

Then you can add the dependency to your dependencies:

    <properties>
        ...

```xml
        <!-- csv-worker version -->
        <csv-worker.version>${latestVersion}</csv-worker.version>
```

        ...
    </properties>
        ...
        <dependencies>
        ...

```xml
            <!-- csv-worker DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>csv-worker</artifactId>
                <version>${csv-worker.version}</version>
            </dependency>
```

        ...
        </dependencies>

</details>


<details>
  <summary>Snapshots (click to expand)</summary>

## 📸 Snapshots

[![Snapshot](https://img.shields.io/badge/dynamic/xml?url=https://oss.sonatype.org/service/local/repositories/snapshots/content/io/github/astrapi69/csv-worker/maven-metadata.xml&label=snapshot&color=red&query=.//versioning/latest)](https://oss.sonatype.org/content/repositories/snapshots/io/github/astrapi69/csv-worker/)

This section describes how to import snapshot versions into your project.
Add the following code snippet to your gradle file in the repositories section:

```
repositories {
   //...
```

```groovy
    maven {
        name "Sonatype Nexus Snapshots"
        url "https://oss.sonatype.org/content/repositories/snapshots"
        mavenContent {
            snapshotsOnly()
        }
    }
```

```
}
```

</details>

# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this library, please consider a donation

over paypal:
<br>
<br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif"
alt="PayPal this"
title="PayPal – The safer, easier way to pay online!"
style="border: none" />
</a>
<br>
<br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over the donation buttons at the top.

## Semantic Versioning

The versions of csv-worker are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for csv-worker are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/csv-worker/fork](https://github.com/astrapi69/csv-worker/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/csv-worker/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or
improvements.

## Contacting the Developers

Do not hesitate to contact the csv-worker developers with your questions, concerns, comments, bug reports, or
feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/csv-worker/issues).

## Credits

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/io.github.astrapi69/csv-worker.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~csv-worker~~~)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**codecov.io**|
|     :---:      |
|[![Coverage Status](https://codecov.io/gh/astrapi69/csv-worker/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/csv-worker)|
|Special thanks to [codecov.io](https://codecov.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/csv-worker.svg)](http://www.javadoc.io/doc/io.github.astrapi69/csv-worker)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
