export async function obtenerToken(clientId: string, clientSecret: string) {
  const url = "http://localhost:9000/oauth2/token";

  const credentials = btoa(`${clientId}:${clientSecret}`);
  const body = new URLSearchParams({
    grant_type: "client_credentials",
    scope: "read",
  });

  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Authorization": `Basic ${credentials}`,
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body,
  });

  if (!response.ok) {
    const error = await response.text();
    throw new Error(error || "Error al obtener el token");
  }

  return await response.json();
}
