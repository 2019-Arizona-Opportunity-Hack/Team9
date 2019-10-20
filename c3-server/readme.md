## Running Postgres DB locally via Docker

docker pull postgres
docker run --name c3 -p 5432:5432 -e POSTGRES_PASSWORD=password postgres