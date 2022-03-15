ChatLog
===================================
Chat-Log System made by AunaCraft
### Info
This **ChatLog** Project servers the purpose to provide an easy to use and reliable backend rest-api.
Creating that in order to look forward to implement it to the [AunaCraft](https://github.com/AunaCraft) Chat system.
### Important:
This project does not contain any type of plugin-implementation for bukkit, bungee or velocity services.
It is only providing the backend for an easy to implement frontend/plugin.

## Logic

The ChatLog System is functioning through a rest-api based on [spring](https://github.com/spring-projects/spring-framework). 
The minecraft server implements a boostrap to communicate with the rest-api.
You are able to use your whole creativity to create the system at minecraft layer.

To understand what you have to save/send when listening to messages this Class Card should help.
You may wonder why we also put the displayName into any message, well the main reason for this was to
be able to record nicknames, nicks and to provide an ability for being able to represent the chat message
more realistic than only fetching the uuid.

##### Message Object

| Field | Purpose                                                                    |
| --------------- |----------------------------------------------------------------------------|
| time | Timestamp representing the time where the message got sent in milliseconds |
| uuid | The uuid of the message sender |
| displayName | The Name displayed in chat at sent time |
| message | The raw message as String object |

If you try getting a chat log from the server you are getting an ChatLog Object

##### Chat-Log-Object

| Field | Purpose                                    |
| ----------------- |--------------------------------------------|
| id | Represents the unique id of the requested chatlog |
| messages | List of all chat  message objects logged   |


## How To Use?

You have to use the API through HTTP-Requests. (Cause its an Rest API wich makes kinda sense lol)

So here is a little overview of request you are able to make

### Get a ChatLog by ID

Your HTML-Request:
``GET http://<yourServer>:<yourPort>/chatlog/v1/get/{logID-here}/``

Response Example:
````json
{
  "id": "e24026ec",
  "messages": 
  [
    {
      "time": 1647281712369,
      "uuid": "6d34d7c6-a73a-4065-af94-60c977329c40",
      "displayName": "FebanUHD",
      "message": "Hello, this is a example message!!!"
    },
    {
      "time": 123454678910,
      "uuid": "859c974c-2e32-4599-ac2e-05c7f06aead8",
      "displayName": "ytendx",
      "message": "Test"
    }
  ]
}
````
### Create a ChatLog

To create a chatlog, you need an API key and then send a post request.
Your POST-Request: `POST http://<yourServer>:<yourPort>/chatlog/v1/create/{api-key-herer}/`

<!-- TODO | Make this description -->
```yml
Content-Type: application/json
Body-Type: List of Chatmessage objects
Example Body:
[
    {
      "time": 1647281712369,
      "uuid": "6d34d7c6-a73a-4065-af94-60c977329c40",
      "displayName": "FebanUHD",
      "message": "Hello, this is a example message!!!"
    },
    {
      "time": 123454678910,
      "uuid": "859c974c-2e32-4599-ac2e-05c7f06aead8",
      "displayName": "ytendx",
      "message": "Test"
    }
]
```
