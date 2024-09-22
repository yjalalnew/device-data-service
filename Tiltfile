# -*- mode: Python -*-

gradlew = "./gradlew"
if os.name == "nt":
  gradlew = "gradlew.bat"

local_resource(
  'device-data-service-image',
  gradlew + ' bootJar',
  deps=['src', 'build.gradle'],
  resource_deps = ['deploy'])

docker_build(
  'device-data-service-image',
  './build/libs',
  dockerfile='./Dockerfile')

k8s_yaml('kubernetes.yaml')
k8s_resource('device-data-service', port_forwards=8182,
             resource_deps=['deploy', 'device-data-service-compile'])