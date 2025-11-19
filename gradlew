#!/bin/bash
set -e

# Скачиваем и используем Gradle 8.4
GRADLE_VERSION=8.4
GRADLE_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
GRADLE_DIR="gradle-${GRADLE_VERSION}"
GRADLE_ZIP="${GRADLE_DIR}-bin.zip"

if [ ! -d "$GRADLE_DIR" ]; then
    echo "Downloading Gradle $GRADLE_VERSION..."
    wget -q "$GRADLE_URL" -O "$GRADLE_ZIP"
    unzip -q "$GRADLE_ZIP"
    rm "$GRADLE_ZIP"
fi

# Используем скачанный Gradle
"$GRADLE_DIR/bin/gradle" "$@"
