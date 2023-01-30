FROM gradle:7.6.0-jdk17-alpine as base
COPY . /home/
WORKDIR /home/

FROM base as dev
CMD ["gradle", "run"]

FROM base as test
CMD ["gradle", "test"]

