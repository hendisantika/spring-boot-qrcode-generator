#!/bin/bash
ssh -p ${SERVER_PORT} ${SERVER_USER}@${SERVER_HOST} -i key.txt -t -t -o StrictHostKeyChecking=no << 'ENDSSH'
cd ~/qrcode
cat .env
set +a
source .env
start=$(date +"%s")
#IMAGE_NAME=qrcode-generator
docker pull hendisantika/$IMAGE_NAME:$IMAGE_TAG

CONTAINER_NAME=qrcode-generator
if [ "$(docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        docker system prune -af
        docker stop $CONTAINER_NAME;
        docker rm $CONTAINER_NAME
    fi
fi

docker run -d --rm -p $APP_SERVER_PORT:$APP_SERVER_PORT --name $CONTAINER_NAME hendisantika/$IMAGE_NAME:$IMAGE_TAG

exit
ENDSSH

if [ $? -eq 0 ]; then
  exit 0
else
  exit 1
fi

end=$(date +"%s")

diff=$(($end - $start))

echo "Deployed in : ${diff}s"
