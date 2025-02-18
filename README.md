# What is Jenkins
Jenkins is an open-source automation tool writen on java, used for Continuous Integration (CI) and Continuous Delivery (CD). It helps automate the building, testing, and deployment of applications, making the software development process faster, more reliable, and more efficient.

# What Jenkis can do...

### Continuous integration (CI)
* Automatically builds and test the code whenever developer push changes to a SCM (GitHub, GitLab, Bitbucket)

### Continuous Delivery (CD) and Continuous Deployment
* Automate the deployment of applications to the diffirent evrironments (Development, Staging, Production)
* With Continuous Delivery, the deployment is automated but requires manual approval.
* With Continuous Deployment, the deployment happens automatically if all test pass.

1. Build Automation
* Building the code, packages application, and create executable artifacts (JAR,WAR, Docker images)
* Supprot various programming languages and build tools, including Maven, Gradle, NPM etc..

2. Test automation
* Run unit test, integration test automatically 

3. Deployment Automation
* Deploys applications to various environments
- Cloud Providers: AWS, Azure, GCP
- Containers: Docker, K8s
- Servers: On-premises or cluod-hosted servers

### Roles
* Jenkins Administrator- Sets up Jenkins cluster, manages it.
* Jenkins User- Creating the actual jobs to run workflows 


### How to install Docker in Jenkins container

Install Jenkins using Docker:

```sh
docker run -p 8080:8080 -p 50000:50000 -d -v /var/run/docker.sock:/var/run/docker.sock -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts
```
Enter container so we can install docker inside of it:
```sh
docker exec -it --user root <container id> bash
```
Run this command to install Docker inside Jenkins container and give premissions: 
```sh
curl https://get.docker.com/ > dockerinstall && chmod 777 dockerinstall && ./dockerinstall
```
Exit container and run following command to change permission on "docker.sock" for added security
```sh
sudo chmod 666 /var/run/docker.sock # Unix socket file, used by the Docker daemon to communicate woth the Docker client
```
Go to your host and login to the Jenkins. Find your password here:
```sh 
docker exec -it <container id> bash
cat var/jenkins_home/secrets/initialAdminPassword
```
Now you can run Docker inside Jenkins container.



### Pipeline as Code
Uses Jenkins file written in Groovy to define CI/CD pipeline as code.
Simple Jenkinsfile:

``` groovy
pipeline { // must be top-level
    agent any // Where to execute. Can be any avaliable agent or node
    stages { // What kind of steps should be executed
        //descibe the stage with it own name and logic
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}
```

### Credentials
Jenkins needs credentials for all the tasks in the pipeline, such as:

* fetch code of git repo
* login to docker registry to push images
* SSH to remote server to deploy

There are 2 types of credentials:

* Global credentials: accessible from everywhere
* System: Only avaliable on Jenkins server, NOT for jenkins jobs

### What is a Jenkins Shared Library?

A Jenkins Shared Library is a way to organize and share reusable code across multiple Jenkins pipelines.
It allows us to define common functions, variables, and steps in a centralized location.

# Why Use Jenkins?
* Automation: Reduces manual effort and errors.
* Speed: Speeds up software delivery.
* Consistency: Ensures consistent builds and deployments.
* Scalability: Handles multiple projects and teams.
###