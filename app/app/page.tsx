"use client";

import { useState } from "react";
import { obtenerToken } from "@/services/auth.service";

export default function LoginPage() {
  const [clientId, setClientId] = useState("");
  const [clientSecret, setClientSecret] = useState("");
  const [token, setToken] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setToken(null);

    try {
      const data = await obtenerToken(clientId, clientSecret);
      setToken(data.access_token);
      localStorage.setItem("access_token", data.access_token);
    } catch (err: any) {
      setError("Credenciales inválidas o el servidor no está disponible.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className="flex flex-col justify-center items-center min-h-screen bg-gray-50 text-gray-800 px-4">
      <div className="w-80 max-w-full flex flex-col items-center text-center">
        <h1 className="text-3xl font-semibold mb-2">Iniciar sesión</h1>
        <p className="text-gray-600 text-sm mb-8 leading-relaxed">
          Introduce tus credenciales de cliente para obtener el token de acceso.
        </p>

        <form onSubmit={handleLogin} className="flex flex-col gap-4 w-full text-left">
          <div>
            <label
              htmlFor="clientId"
              className="block text-sm font-medium text-gray-700 mb-1"
            >
              Client ID
            </label>
            <input
              id="clientId"
              type="text"
              value={clientId}
              onChange={(e) => setClientId(e.target.value)}
              placeholder="Ejemplo: client-app"
              required
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
            />
          </div>

          <div>
            <label
              htmlFor="clientSecret"
              className="block text-sm font-medium text-gray-700 mb-1"
            >
              Client Secret
            </label>
            <input
              id="clientSecret"
              type="password"
              value={clientSecret}
              onChange={(e) => setClientSecret(e.target.value)}
              placeholder="Ejemplo: secret123"
              required
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
            />
          </div>

          <button
            type="submit"
            disabled={loading}
            className="w-full py-2 mt-2 bg-blue-600 hover:bg-blue-700 text-white rounded-md font-medium transition disabled:opacity-50"
          >
            {loading ? "Conectando..." : "Obtener Token"}
          </button>
        </form>

        {error && (
          <p className="text-red-500 text-sm mt-4 text-center">{error}</p>
        )}

        {token && (
          <div className="mt-6 bg-gray-100 p-3 rounded-md border border-gray-300 w-full text-left overflow-x-auto">
            <p className="text-green-600 text-sm font-mono mb-1">
              Token de acceso:
            </p>
            <div className="text-xs text-gray-700 whitespace-nowrap font-mono">
              {token}
            </div>
          </div>
        )}
      </div>
    </main>
  );
}
