# link-preview-server

[OG(Open Graph)](https://ogp.me/) LinkPreview는 입력받은 url로 og 정보를 크롤링해서 미리보기에 필요한 정보를 응답해줍니다. 

## Request
| Field | Type | Description |
| :--- | :--- | :--- |
| `url` | `string` | **Required** link url |

```javascript
{
  "url": string
}
```

## Response
| Field | Type | Description |
| :--- | :--- | :--- |
| `title` | `string` | `<meta property="og:title"/>` |
| `image` | `string` | `<meta property="og:image"/>` |
| `description` | `string` | `<meta property="og:description"/>` |
| `url` | `string` | `<meta property="og:url"/>` |

```javascript
{
  "title": string,
  "image": string,
  "description": string,
  "url": string
}
```

## Status Codes
| HTTP Status Code | Description |
| :--- | :---|
| `200` | OK |
| `201` | CREATED |
| `400` | BAD REQUEST |
| `404` | NOT FOUND |
| `500` | INTERNAL SERVER ERROR |

| API Status | Description |
| :--- | :---|
| `OK` | 성공 |
| `Failed` | 실패 |

#### 성공
```json
{
  "status":"OK",
  "data":{
    "title":"title",
    "description":"description",
    "image":"image",
    "url":"url"
  },
  "error":{
    "code":"",
    "message":""
  }
}
```

#### 실패
```json
{
    "status": "Failed",
    "error": {
        "code": "code",
        "message": "message"
    }
}
```

## Examples
#### Request
```shell
curl -X POST http://localhost:8080/api \
-H "Content-Type: application/json" \
-d '{
  "url": "https://www.naver.com"
}'
```

#### Response
```json
{
  "status":"OK",
  "data":{
    "title":"네이버",
    "description":"네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요",
    "image":"https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png",
    "url":"https://www.naver.com/"
  },
  "error":{
    "code":"",
    "message":""
  }
}
```
