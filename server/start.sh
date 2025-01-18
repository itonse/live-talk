echo "Build Project"

./gradlew clean build

echo "Start Server"

cd ./build/libs
java -jar live-talk-0.0.1-SNAPSHOT.jar