# In this project, we are building a Java-Maven app and deploying it to a private DockerHub repository automaticaly using Jenkins.
### Steps
1. Install Docker on the server
2. Install Jenkins using Docker on the server
3. Configure Docker inside Jenkins container
4. Configure credentials for GitHub and DockerHub
5. Configure Jenkinsfile  
6. Run job in Jenkins UI or configure WebHook to run it automatically 
7. Connect to the server and run container using ```docker run``` command 
8. Check in the browser if app is running
9. Use docker logs <CONTAINER_NAME> for bug fix