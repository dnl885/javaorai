# API Reference

Dive into the specifics of each API endpoint by checking out our complete documentation.

## Books

All the methods associated with `CRUD`ing some books. Which isn't as weird as it sounds:

{% swagger method="get" path="/books" baseUrl="https://app.com/api" summary="" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="Books are found" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}

{% swagger-response status="204: No Content" description="No books are found, list is empty" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
