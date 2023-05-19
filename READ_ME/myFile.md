# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **spring-boot-starter-data-jpa**
 - **mysql-connector**
 - **lambok**
 - **jbcrypt**

 - **spring-boot-starter-test**
 


# Models Used



 - **User**
 -  **Admin**
 -  **PostLikes**
 -  **Comment**
 -  **Followers**
 -  **following**
 -  **Authentication**
 -  **post**


	
	



#  Data flow

- **User send a request to ApI endpoint**
- **api forward it to the controller**
- **controller forward it to the Service layer**
- **service layer provide the necessary buciness logic and ask the repository for data**
- **Repository fetch the data from Mysql and give it back to service layer**
- **service layer give it to controller**
- **contoller give it to api**
- **Api give the response to user**


#  Api end points used

- **user/signin**
- **user/signup**
- **user/signout**
- **user/follow/{myId}/{otherId}**
- **user/likes**
- **post/add**
- **post/get**
- **admin/toggleBlueTick**
- **comment/add**








	
	


  


	







	



# DataBase Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*Mysql*



</details>






  




# Summary

 Spring boot Instagram  project using Mysql us database with proper authentictaions and validations .
These project will have the following features
**UserSignup**,
**usersignin**,
**userSignout**,
**addpost**,
**likepost**,
**followusers**
**getlikecount**
.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

