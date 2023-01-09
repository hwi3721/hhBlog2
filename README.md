# hhBlog

항해블로그

ERD.

<img width="845" alt="Screen Shot 2023-01-04 at 17 05 41" src="https://user-images.githubusercontent.com/100186336/210510397-4cf9a742-c817-4c26-a6c3-afa8ff4a6c5d.png">



API 명세서.
이렇게 하는거 맞나..
{
	"info": {
		"_postman_id": "46c5a810-4098-45f9-aa7a-4624d94277a9",
		"name": "항해블로그",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "25070444"
	},
	"item": [
		{
			"name": "getblogs{id}",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/blogs",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"blogs"
					]
				}
			},
			"response": [
				{
					"name": "getblogs",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/api/blogs",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"blogs"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:07:28 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "[\n    {\n        \"createdAt\": \"2023-01-04T15:22:48.322238\",\n        \"modifiedAt\": \"2023-01-04T15:22:48.322238\",\n        \"title\": \"제목3\",\n        \"contents\": \"내용\"\n    },\n    {\n        \"createdAt\": \"2023-01-04T15:22:44.958982\",\n        \"modifiedAt\": \"2023-01-04T15:24:34.095744\",\n        \"title\": \"제목\",\n        \"contents\": \"내용2222222222\"\n    }\n]"
				}
			]
		},
		{
			"name": "getblog{id}",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/blogs/3",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"blogs",
						"3"
					]
				}
			},
			"response": [
				{
					"name": "getblog{id}",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/api/blogs/3",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"blogs",
								"3"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:09:31 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"createdAt\": \"2023-01-04T15:22:48.322238\",\n    \"modifiedAt\": \"2023-01-04T15:22:48.322238\",\n    \"title\": \"제목3\",\n    \"contents\": \"내용\"\n}"
				}
			]
		},
		{
			"name": "createBlog",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\"username\":\"이름22\",\"password\":\" qwe123\"}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/user/join",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"user",
						"join"
					]
				}
			},
			"response": [
				{
					"name": "join",
					"originalRequest": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\"username\":\"이름3\",\"password\":\" qwe123\"}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/user/join",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"user",
								"join"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "plain",
					"header": [
						{
							"key": "Authorization",
							"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODE5OTI1LCJpYXQiOjE2NzI4MTYzMjV9.u6tX6_kINh8N18gJ-B-I-3T5Uc40BIAJ60ngxoNRK1s"
						},
						{
							"key": "Content-Type",
							"value": "text/plain;charset=UTF-8"
						},
						{
							"key": "Content-Length",
							"value": "7"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:12:05 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "success"
				}
			]
		},
		{
			"name": "login",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\"username\":\"이름3\",\"password\":\" qwe123\"}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/user/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"user",
						"login"
					]
				}
			},
			"response": [
				{
					"name": "login",
					"originalRequest": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\"username\":\"이름3\",\"password\":\" qwe123\"}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/user/login",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"user",
								"login"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "plain",
					"header": [
						{
							"key": "Authorization",
							"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODE5OTgwLCJpYXQiOjE2NzI4MTYzODB9.FgDFDD30Z_CNJCkxA8ZhNAHNnVRpCAZzDjqLX5U942k"
						},
						{
							"key": "Content-Type",
							"value": "text/plain;charset=UTF-8"
						},
						{
							"key": "Content-Length",
							"value": "7"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:13:00 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "success"
				}
			]
		},
		{
			"name": "createBlog",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwNjQ0LCJpYXQiOjE2NzI4MTcwNDR9.OF5ge2sdIYZVQEwUzvs402qzFEcBBHQ8JIlp55vPhlM",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"title\":\"제목\",\"contents\":\"내용\"}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/blogs",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"blogs"
					]
				}
			},
			"response": [
				{
					"name": "createBlog",
					"originalRequest": {
						"method": "POST",
						"header": [
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwNjQ0LCJpYXQiOjE2NzI4MTcwNDR9.OF5ge2sdIYZVQEwUzvs402qzFEcBBHQ8JIlp55vPhlM",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\"title\":\"제목\",\"contents\":\"내용\"}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/blogs",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"blogs"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:24:32 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"createdAt\": \"2023-01-04T16:24:32.159305\",\n    \"modifiedAt\": \"2023-01-04T16:24:32.159305\",\n    \"title\": \"제목\",\n    \"contents\": \"내용\"\n}"
				}
			]
		},
		{
			"name": "updateBlog{id}",
			"request": {
				"method": "PATCH",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwNjQ0LCJpYXQiOjE2NzI4MTcwNDR9.OF5ge2sdIYZVQEwUzvs402qzFEcBBHQ8JIlp55vPhlM",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"title\":\"제목\",\"contents\":\"내용\"}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/blogs",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"blogs"
					]
				}
			},
			"response": [
				{
					"name": "updateBlog{id}",
					"originalRequest": {
						"method": "PATCH",
						"header": [
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwOTE3LCJpYXQiOjE2NzI4MTczMTd9.JBLmejxgyRLV61wJuGZzIHRG4muaGyv6dNloH0ZAOYI",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\"title\":\"제목4\",\"contents\":\"내용4을 수정한 내용\"}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/blogs/4",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"blogs",
								"4"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:29:39 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"createdAt\": \"2023-01-04T16:24:32.159305\",\n    \"modifiedAt\": \"2023-01-04T16:24:32.159305\",\n    \"title\": \"제목4\",\n    \"contents\": \"내용4을 수정한 내용\"\n}"
				}
			]
		},
		{
			"name": "deleteBlog{id}",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwOTE3LCJpYXQiOjE2NzI4MTczMTd9.JBLmejxgyRLV61wJuGZzIHRG4muaGyv6dNloH0ZAOYI",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/blogs/4",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"blogs",
						"4"
					]
				}
			},
			"response": [
				{
					"name": "deleteBlog{id}",
					"originalRequest": {
						"method": "DELETE",
						"header": [
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLsnbTrpoQzIiwiZXhwIjoxNjcyODIwOTE3LCJpYXQiOjE2NzI4MTczMTd9.JBLmejxgyRLV61wJuGZzIHRG4muaGyv6dNloH0ZAOYI",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/blogs/4",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"blogs",
								"4"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "plain",
					"header": [
						{
							"key": "Content-Type",
							"value": "text/plain;charset=UTF-8"
						},
						{
							"key": "Content-Length",
							"value": "22"
						},
						{
							"key": "Date",
							"value": "Wed, 04 Jan 2023 07:30:38 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "삭제되었습니다."
				}
			]
		}
	]
}
