<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
    <head>
      <title>Países e Bandeiras</title>
    </head>
    <body>
      <h1>Lista de Países e Bandeiras</h1>
      <table border="1">
        <tr>
          <th>Pais</th>
          <th>Bandeira</th>
        </tr>
        <xsl:apply-templates select="paises/pais"/>
      </table>
    </body>
  </html>
</xsl:template>

<xsl:template match="pais">
  <tr>
    <td><xsl:value-of select="nome"/></td>
    <td>
      <img src="{bandeira}" alt="{nome} Bandeira" width="120" />
    </td>
  </tr>
</xsl:template>

</xsl:stylesheet>
