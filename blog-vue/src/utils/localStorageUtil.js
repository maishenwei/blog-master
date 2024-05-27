export function getlocalStorage(key) {
  let temp = window.localStorage.getItem(key);
  if (temp) {
    return temp
  } else {
    return null
  }
}
// 设置
export function setlocalStorage(key, value) {
  window.localStorage.setItem(key, value);
}
// 移除
export function removelocalStorage(key) {
  window.localStorage.removeItem(key);
}