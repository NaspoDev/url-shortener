# URL Shortener

A URL Shortener webapp made with React and Spring Boot.

https://lnk.naspoapps.com

## How it Works

Simply paste in a URL that you want to shorten, and press "shorten".

The app will return a shortened URL that will redirect to the original URL.

## Tech Stack

- React (with TypeScript)
- Spring Boot (Java)
- MySQL
- Served with Docker

## Deployment

### Frontend

_Steps from `/url-shortener-client`_

1. Build the project: `npm run build`
2. Deploy the static files on a web server.

### Backend

_Steps from `/server`_

<u>Step 1: Build the docker image</u>\
`docker build -t naspo/url-shortener:<tag> .`\
_The tag should be the version number of the application._

<u>Step 2: Push the image</u>\
Push the docker image to the docker hub.\
`docker push naspo/url-shortener:<tag>`

<u>Step 3: Pull the image</u>\
Pull the image on the server.\
`docker image pull naspo/url-shortener:<tag>`

<u>Step 4: Create .env file</u>\
Create a `.env` file containing the following properties:

```
DATABASE_HOST=
DATABASE_PORT=
DATABASE_USER=
DATABASE_PASSWORD=
DATABASE_NAME=
RUN_ENV=production
```

This `.env` file will be passed to the docker container when we run the image.\
(The .env file must be kept private and should not be committed to version control).

<u>Step 5: Run the image in a container</u>\
`docker run -d -p 8080:8080 --name url-shortener-server --env-file path/to/.env --restart unless-stopped --add-host=host.docker.internal:host-gateway naspo/url-shortener:<tag>`

_Note for the above command: URL Shortener's database is deployed on the same server, so `host.docker.internal` is used to access the host machine. However this doesn't implicitly work on Linux so a mapping is created, hence the `--add-host` flag._
