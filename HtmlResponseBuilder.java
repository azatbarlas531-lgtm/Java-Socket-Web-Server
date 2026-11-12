
public class HtmlResponseBuilder {

    public static String buildHtmlPage() {
        return """
<!DOCTYPE html>
<html lang="tr">
<head>
<meta charset="UTF-8">
<title>Kişisel Web Sayfası</title>
<style>
body {
font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
background-color: #f4f7f6;
color: #333;
margin: 40px;
line-height: 1.6;
}
.card {
background: white;
max-width: 650px;
margin: auto;
padding: 30px;
border-radius: 12px;
box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}
h1 {
color: #2c3e50;
font-size: 32px;
border-bottom: 2px solid #3498db;
padding-bottom: 10px;
margin-top: 0;
}
h2 {
color: #7f8c8d;
font-size: 20px;
margin-bottom: 20px;
}
p {
font-size: 16px;
color: #555;
}
.highlight {
color: #e74c3c;
font-weight: bold;
}
</style>
</head>
<body>
<div class="card">
<h1>Azat Barlas</h1>
<h2>Öğrenci No: 1250505046</h2>
<p><strong>Biyografi:</strong></p>
<p>Merhaba, ben <span class="highlight">Yazılım Mühendisliği</span> öğrencisiyim. Nesne Yönelimli Programlama, Ağ Teknolojileri ve Web Sunucu Mimarileri konularıyla ilgilenmekteyim. Java platformu üzerinde düşük seviyeli TCP/IP socket programlama ve performans odaklı sistem tasarımları geliştirmekteyim.</p>
</div>
</body>
</html>
""";
    }
}